import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

/**
 * @author Alexey Skadorva
 */
class Bot extends TelegramLongPollingBot {

    private static final String BOT_NAME = "hellower_bot";
    private static final String TOKEN_VALUE = "454294114:AAHaxNjCIca9vzHgsySJ-QpCqJGJjLoCTa0";


    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();
        if (txt.equals("/start")) {
            sendMsg(msg, "Привет! Как тебя зовут");
        } else {
            if (txt.equals("/weather")) {
                Weather weather = new Weather();
                try {
                    sendMsg(msg, weather.getTemperature());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                sendMsg(msg, "Правильно не " + txt + " a пееееееееееес! Сегодня накидаю тебе палок.");
            }
        }
    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return TOKEN_VALUE;
    }

    @SuppressWarnings("deprecation")
    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        try {
            sendMessage(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}