import Communication.ClientArgument;
import Communication.Communication;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {

    public static void main(String []arg) throws JAXBException {
        String port = arg[2];
        String host = arg[1];
        String nameFile = arg[0];
        try {
        ClientArgument clientArgument = new ClientArgument();
        Communication communication = null;
        String and = new String();



        try(DatagramChannel channel = DatagramChannel.open())
        {


            ByteBuffer buffer = null;
            SocketAddress address = new InetSocketAddress( InetAddress.getByName(host), Integer.parseInt(port));
            channel.bind(null);
            channel.socket().setSoTimeout(5000);


            while(!and.equals("exit"))
            {

                //Ожидаем ввод сообщения серверу
                clientArgument.param(nameFile);

                and = clientArgument.getType();

                communication = new Communication(clientArgument.getType(),clientArgument.getParams(),clientArgument.getCityArgument());
                buffer = ByteBuffer.wrap(communication.serializeToString().getBytes());

                //Отправляем сообщение
                channel.send(buffer, address);
                if (and.equals("exit")){break;}

                { //получение входящих данных
                    byte[] buf = new byte[65536];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    boolean successfullAttempt = false;

                    try {
                        channel.socket().receive(packet);
                        successfullAttempt = true;

                    } catch (SocketTimeoutException e) {
                        System.out.println("Server is unavailable...");
                    }
                    String received;
                    if (successfullAttempt) {
                        received = new String(packet.getData(), 0, packet.getLength());
                    } else {
                        received = "Can't connect to server";
                    }
                    buffer.flip();



                    String s = new String(buf, 0, buf.length);
                    System.out.println('\n'+"Ответ сервера: " + '\n' + s + '\n');

                }

            }

        }catch(IOException e)
        {
            System.err.println("IOException " + e);
        }
        System.out.println("Работа заверщена.");
        System.exit(0);
        }catch (Exception e){
            System.out.println("Error "+ e);
        }
    }
}