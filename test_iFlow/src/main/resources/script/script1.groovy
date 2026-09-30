import com.sap.gateway.ip.core.customdev.util.Message;

def Message processData(Message message) {
    // 1. Get the payload safely as a String
    String body = message.getBody(java.lang.String.class);
    
    // 2. Safely get the Message Log interface
    def messageLog = messageLogFactory.getMessageLog(message);
    
    if (messageLog != null && body != null) {
        // 3. Write the payload to the log attachment
        messageLog.addAttachmentAsString("Payload Log", body, "text/plain");
    }
    
    return message;
}
