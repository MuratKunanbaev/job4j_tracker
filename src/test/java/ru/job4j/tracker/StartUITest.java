package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import java.util.Scanner;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /*@Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput (
                new String[] {"0",String.valueOf(item.getId()), replacedName,"1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }
    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
       Tracker tracker = new Tracker();
       Item item = tracker.add(new Item("Deleted item"));
       Input in = new StubInput(
               new  String[] {"0", String.valueOf(item.getId()), "1"}
       );
       UserAction[] actions = {
               new DeleteAction(out),
               new ExitAction()
       };
      new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu: " + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu: " + ln +
                        "0. Show all items" + ln +
                        "1. Exit Program" + ln +
                        "=== Show all  items ====" + ln +
                        "Хранилище еще не содержит заявок" + ln + "Menu: " + ln +
                        "0. Show all items" + ln +
                        "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "Find item by name", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu: " + ln +
                        "0. Find Item By Name" + ln +
                        "1. Exit Program" + ln +
                        "=== Find items by name ====" + ln +
                        "Заявки с именем: Find item by name не найдены." + ln +
                        "Menu: " + ln +
                        "0. Find Item By Name" + ln +
                        "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find by id"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()),"1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in,tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln +
                "0. Find Item By Id" + ln +
                "1. Exit Program" + ln +
                "=== Find item by id =====" + ln +
                "Item{id=1, name='Find by id'}" + ln
                + "Menu: " + ln +
                "0. Find Item By Id" + ln +
                "1. Exit Program" + ln
        ));
    }*/

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu: " + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 ...0" + ln
                        + "Menu: " + ln
                        + "0. Exit Program" + ln
                )
        );
    }
}