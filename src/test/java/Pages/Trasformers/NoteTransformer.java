package Pages.Trasformers;

import Pages.Wrappers.NoteCard;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteTransformer {

    public static List<NoteCard> wrapNotes(@NotNull List<SelenideElement> elements) {
        if (elements.isEmpty()) {
            return Collections.emptyList();
        }
        List<NoteCard> noteCardList = new ArrayList<NoteCard>();
        for (SelenideElement selenideElement : elements) {
            noteCardList.add(new NoteCard(selenideElement));
        }
        return noteCardList;
    }
}
