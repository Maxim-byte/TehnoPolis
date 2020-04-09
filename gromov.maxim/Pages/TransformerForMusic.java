package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransformerForMusic {
    public static List<Music> musics(ElementsCollection selenideElements, SelenideDriver driver) {
        if (selenideElements == null || selenideElements.isEmpty()) {return null;};
        List<Music> musicList = new ArrayList<Music>();
        for (SelenideElement element : selenideElements) {
            musicList.add(new Music(element, driver));
        }
        return musicList;
    }
}