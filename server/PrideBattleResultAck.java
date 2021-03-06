/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wtserver.server;

import java.nio.ByteBuffer;
import java.util.Random;
import wtserver.client.ServerMsg;

/**
 *
 * @author MSI
 */
public class PrideBattleResultAck extends ServerMsg {
    private final short msgId = ServerMsg.CS_PR_BATTLERESULT_ACK;
    
    public PrideBattleResultAck()
    {
        size = 24;
        buffer = ByteBuffer.allocate(512);
    }
    
    public byte [] getData(short seqNum)
    {
        buffer.position(0);
        byte random = (byte) new Random().nextInt();
        addByte(random);
        addShort(msgId);
        addShort(seqNum);
        addShort((short) 0);
        byte checksum = 0;
        addByte(checksum);
        
        byte b[] = {00, 0x00, 0x00, 0x00, 0x00, 0x2A, 0x00, 0x00, 0x00, (byte)0x8D, 0x11, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x1A, 0x01, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00, 0x6A, 0x00, 0x00, 0x00, 0x01, 0x02, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, 0x41, 0x04, 0x00, 0x00, 0x00, 0x04, 0x00, 0x00, 0x00, 0x09, 0x00, 0x00, 0x00, 0x3A, 0x01, 0x00, 0x00, 0x02, 0x09, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x55, 0x00, 0x00, 0x00, 0x01, 0x0A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte)0xCF, 0x01, 0x00, 0x00, 0x00, 0x11, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x12, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte)0x96, 0x01, 0x00, 0x00, 0x00, 0x14, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x64, 0x00, 0x00, 0x00, 0x00, 0x20, 0x00, 0x00, 0x00, 0x0E, 0x00, 0x00, 0x00, 0x02, 0x03, 0x00, 0x00, 0x01, 0x30, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, (byte)0x80, 0x01, 0x00, 0x00, 0x00, 0x41, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x60, 0x00, 0x00, 0x00, 0x01, (byte)0x81, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x00, (byte)0xB4, 0x00, 0x00, 0x00, 0x02, (byte)0x84, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, (byte)0x8D, 0x01, 0x00, 0x00, 0x00, 0x00, (byte)0x80, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x12, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x12, 0x00, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x12, 0x00, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x12, 0x00, (byte)0x80, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x30, 0x00, (byte)0x80, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x12, 0x00, 0x00, 0x08, 0x00, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, 0x00, 0x30, 0x00, 0x00, 0x08, 0x00, 0x00, 0x00, 0x00, 0x01};
        
        for(int i = 0; i < b.length; i++)
        {
            addByte(b[i]);
        }

        size = (short) buffer.position();
        if((size - 8) % 16 > 0)
        {
            size -= (size - 8) % 16;
            size += 16;
        }
        short pSize = (short) ((size - 8) / 16);
        buffer.position(5);
        addShort(pSize);
        for(int i = 0; i < 7; i++)
        {
            checksum += buffer.get(i);
        }
        addByte(checksum);
        return buffer.array();
    }
}
