package com.hxzycs.oa.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hxzycs.oa.entity.Message;
import com.hxzycs.oa.service.MessageService;
@Service("myWebSocketHandler")
@Component
public class MyWebSocketHandler implements WebSocketHandler {
	private static final List<WebSocketSession> users = new ArrayList<>();
	@Resource(name="messageService")
	private MessageService messageService;

	public static final Map<Long, WebSocketSession> userSocketSessionMap;

    static {
        userSocketSessionMap = new HashMap<Long, WebSocketSession>();
    }

    //����ʵ�����Ӻ�
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
    	System.out.println("����ʵ�����Ӻ�");
    	Long uid = (Long) webSocketSession.getAttributes().get("uid");
        if (userSocketSessionMap.get(uid) == null) {
            userSocketSessionMap.put(uid, webSocketSession);
        }
        sendMessagesToUsers(new TextMessage("�������Ϸ�����ά��,��ע��"));
    }

    //������Ϣǰ�Ĵ���
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
    	System.out.println(webSocketSession);
    	System.out.println(webSocketMessage.toString());
        if(webSocketMessage.getPayloadLength()==0)return;

        //�õ�Socketͨ���е����ݲ�ת��ΪMessage����
        Message msg=new Gson().fromJson(webSocketMessage.getPayload().toString(),Message.class);

        Timestamp now = new Timestamp(System.currentTimeMillis());
        msg.setMessageDate(now);
        //����Ϣ���������ݿ�
        messageService.create(msg);

        //����Socket��Ϣ
        sendMessageToUser(msg.getToId(), new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
    }

    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    /**
     * �ڴ�ˢ��ҳ����൱�ڶϿ�WebSocket����,ԭ���ھ�̬����userSocketSessionMap�е�
     * WebSocketSession���ɹر�״̬(close)������ˢ�º�ĵڶ������ӷ�����������
     * ��WebSocketSession(open״̬)�ֲ�����뵽userSocketSessionMap��,�����������޷�������Ϣ
     * ���Ӧ���ڹر����������������ȥ��userSocketSessionMap�е�ǰ����close״̬��WebSocketSession��
     * ���´�����WebSocketSession(open״̬)���Լ��뵽userSocketSessionMap��
     * @param webSocketSession
     * @param closeStatus
     * @throws Exception
     */
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

        System.out.println("WebSocket:"+webSocketSession.getAttributes().get("uid")+"close connection");
        Iterator<Map.Entry<Long,WebSocketSession>> iterator = userSocketSessionMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Long,WebSocketSession> entry = iterator.next();
            if(entry.getValue().getAttributes().get("uid")==webSocketSession.getAttributes().get("uid")){
                userSocketSessionMap.remove(webSocketSession.getAttributes().get("uid"));
                System.out.println("WebSocket in staticMap:" + webSocketSession.getAttributes().get("uid") + "removed");
            }
        }
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * �����е��û�������Ϣ
     */
    public void sendMessagesToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                // isOpen()���߾ͷ���
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //������Ϣ��ʵ��
    public void sendMessageToUser(Long uid, TextMessage message)
            throws IOException {
        WebSocketSession session = userSocketSessionMap.get(uid);
        if (session != null && session.isOpen()) {
            session.sendMessage(message);
        }
    }

}
