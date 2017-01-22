package test.netty.test.object.processor;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import test.netty.test.object.Person;

public class ObjectEncoder extends
		MessageToByteEncoder<Person> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Person msg,
			ByteBuf out) throws Exception {
		// TODO Auto-generated method stub
		byte[] body = convertToBytes(msg); // 将对象转换为byte
		int dataLength = body.length; // 读取消息的长度
		out.writeInt(dataLength); // 先将消息长度写入，也就是消息头
		out.writeBytes(body); // 消息体中包含我们要发送的数据
	}

	private byte[] convertToBytes(Person msg) {
		byte[] bytes = null;
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(msg);
			bytes = bo.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bo != null) {
				try {
					bo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oo != null) {
				try {
					oo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bytes;
	}
}
