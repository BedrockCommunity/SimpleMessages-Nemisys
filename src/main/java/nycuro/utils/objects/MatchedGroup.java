package nycuro.utils.objects;

import lombok.Data;

@Data
public class MatchedGroup {

    public String value;
    public int start;
    public int end;

    public MatchedGroup(String value, int start, int end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }
}
