package test.netty.test.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class HelloClientInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline pipeline = channel.pipeline();

        
        
//        pipeline.addLast("decoder", new StringDecoder());
        /*
         * 这个地方的 必须和服务端对应上。否则无法正常解码和编码
         * 
         * 解码和编码 我将会在下一张为大家详细的讲解。再次暂时不做详细的描述
         */
//		pipeline.addLast("encoder", new StringEncoder());
//        pipeline.addLast(new LineBasedFrameDecoder(8192));

        // 客户端的逻辑
        pipeline.addLast("handler", new HelloClientHandler());
	}

}
