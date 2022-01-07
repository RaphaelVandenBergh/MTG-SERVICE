package fact.it.mtgservice.controlller;

import fact.it.mtgservice.model.Card;
import fact.it.mtgservice.model.DeckOverview;
import fact.it.mtgservice.model.Decks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeckOverviewController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${CardServicebaseurl}")
    private String CardServicebaseurl;

    @Value("${DeckServicebaseurl}")
    private String DeckServicebaseurl;

    @GetMapping("/decks/{author}/{name}/cards")
    public DeckOverview getCardDetailsByDeck(@PathVariable String name, @PathVariable String author){
        Decks deck = restTemplate.getForObject("http://"+DeckServicebaseurl+"/decks/authors/{author}/{name}", Decks.class, author,name);
        DeckOverview deckOverview = new DeckOverview();
        deckOverview.setDeckname(deck.getName());
        deckOverview.setColors(deck.getColors());
        deckOverview.setAuthor(deck.getAuthor());
        deckOverview.setCards(deck.getCards());
        for (String card:deckOverview.getCards()) {
            System.out.println(restTemplate.getForObject("http://"+CardServicebaseurl+"/cards/"+card,Card.class));
            //deckOverview.getCardList().add(restTemplate.getForObject("http://"+CardServicebaseurl+"/cards/"+card, Card.class));
            //System.out.println(restTemplate.getForObject("http://"+CardServicebaseurl+"/cards/"+card,Card.class));

        }

        return deckOverview;
    }
}
