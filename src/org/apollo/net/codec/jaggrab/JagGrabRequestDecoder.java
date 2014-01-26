package org.apollo.net.codec.jaggrab;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * A {@link OneToOneDecoder} for the JAGGRAB protocol.
 * 
 * @author Graham
 */
public final class JagGrabRequestDecoder extends MessageToMessageDecoder<String> {

	@Override
	protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) {
		String request = (String) msg;
		if (request.startsWith("JAGGRAB /")) {
			String filePath = request.substring(8).trim();
			out.add(new JagGrabRequest(filePath));
		} else {
			throw new IllegalArgumentException("corrupted request line");
		}
	}

}