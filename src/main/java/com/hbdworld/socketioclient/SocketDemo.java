package com.hbdworld.socketioclient;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class SocketDemo {

    public void test() throws URISyntaxException {

        //opts
        IO.Options opts = new IO.Options();
        opts.forceNew = true;
        opts.query = "access_token=java-user";

        //socket.io
        Socket socket = IO.socket("http://localhost:3000", opts);
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {

                // Sending an object
                JSONObject obj = new JSONObject();
                try {
                    obj.put("type", "message");
                    obj.put("message", "this is message");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                socket.emit("message", obj);
                //socket.disconnect();
            }

        }).on("message", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                JSONObject obj = (JSONObject) args[0];

                try {
                    Object type = obj.get("type");
                    System.out.println(type);
                    Object message = obj.get("message");
                    System.out.println(message);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
            }

        });
        socket.connect();
    }

}
