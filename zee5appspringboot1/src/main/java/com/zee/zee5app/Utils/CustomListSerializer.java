package com.zee.zee5app.Utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zee.zee5app.dto.Login;

public class CustomListSerializer extends StdSerializer<Login> {

	
	
	
	
	
    @Override
	public void serialize(Login value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
    	gen.writeObject(value);
		
	}
    
    
    
	protected CustomListSerializer(Class<Login> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

}
