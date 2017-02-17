package altaqias.ragatanga.api.webservice.configs;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

import org.glassfish.jersey.CommonProperties;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class JacksonFeature implements Feature {

	@SuppressWarnings("serial")
	private static final ObjectMapper mapper =
	new ObjectMapper(){{
		configure(SerializationFeature.INDENT_OUTPUT, true);
		configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

	}}; 

	private static final JacksonJaxbJsonProvider provider =
			new JacksonJaxbJsonProvider(){{
				setMapper(mapper);
			}};

			@Override
			public boolean configure(FeatureContext context) {
				String postfix = '.' + context.getConfiguration().getRuntimeType().name().toLowerCase();

				context.property( CommonProperties.MOXY_JSON_FEATURE_DISABLE + postfix, true );
				context.register(provider);
				return true;
			}

}
