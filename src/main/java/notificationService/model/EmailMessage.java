package notificationService.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class EmailMessage extends Message {

    private String emailTo;
    private List<String> emailCC;

    public EmailMessage(String emailTo, List<String> emailCC, String text, Date sendDate) {
        super(ChannelKind.EMAIL, text, sendDate);
        this.emailTo = emailTo;
        this.emailCC = emailCC;
    }
//
//    public String convertToCSV() {
//        String[] data = {emailTo, String.join( ",", emailCC), getText(), getSendDate().toLocaleString()};
//
//        return Stream.of(data)
//                .map(this::escapeSpecialCharacters)
//                .collect(Collectors.joining(";"));
//    }
//
//    private String escapeSpecialCharacters(String data) {
//        String escapedData = data.replaceAll("\\R", " ");
//        if (data.contains(";") || data.contains("\"") || data.contains("'")) {
//            data = data.replace("\"", "\"\"");
//            escapedData = "\"" + data + "\"";
//        }
//        return escapedData;
//    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "emailTo='" + emailTo + '\'' +
                ", emailCC=" + emailCC +
                '}';
    }
}
