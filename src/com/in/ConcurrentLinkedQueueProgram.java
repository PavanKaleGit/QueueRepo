package com.in;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueProgram {
	public static void main(String[] args) {
		
		ConcurrentLinkedQueue<String> packetQueue = new ConcurrentLinkedQueue<>();
		
		
		packetQueue.add(" Packet from source 1");
		packetQueue.add(" Packet from source 2");
		packetQueue.add(" Packet from source 3");
		
		
		Thread router = new Thread(() -> {
			
			while(! packetQueue.isEmpty())
			{
				String packet = packetQueue.poll();
				if(packet != null)
				{
					System.out.println(" Routing " + packet);
				}
			}
		});
		
		
		router.start();
		try
		{
			router.join();
			
		}catch(InterruptedException  e)
		{
			
			Thread.currentThread().interrupt();
			
		}
		
		
	}

}
