package util;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Handles deserialization for BigDecimals
 * @author maike
 *
 */
public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

	/**
	 * Treats the json {@code String} to be converted as {@code BigDecimal}.
	 * If the string is null or empty returns {@code null}
	 * @return {@code BigDecimal} The deserialized {@code BigDecimal} or {@code null}
	 */
	@Override
	public BigDecimal deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		BigDecimal value = null;
		String textToBeConverted = parser.getText();
		if(textToBeConverted != null && !textToBeConverted.isEmpty()) {			
			textToBeConverted = textToBeConverted.replace(".", "").replaceAll(",", ".");
			value = new BigDecimal(textToBeConverted);
		}
		return value;
	}

}
