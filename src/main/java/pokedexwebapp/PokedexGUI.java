package pokedexwebapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexGUI {

    public PokedexGUI() {
        // Janela Principal
        JFrame frame = new JFrame("Pokedex");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Painel
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        frame.add(panel);
        placeComponents(panel);

        //Exibir a janela
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        //Campo User Input
        JLabel userLabel = new JLabel("Enter Pokemon Name:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(160, 20, 165, 25);
        panel.add(userText);

        //Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(160, 60, 100, 25);
        panel.add(searchButton);

        //Label for Search result
        JLabel resultLabel = new JLabel("");
        resultLabel.setForeground(Color.black);
        resultLabel.setBounds(10, 100, 350, 25);
        panel.add(resultLabel);

        // Label for Image
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(100, 150, 200, 100);
        panel.add(imageLabel);


        //Search Button function
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pokemonName = userText.getText();
                PokedexApi pokemonApi = new PokedexApi(pokemonName);
                pokemonApi.getPokemonInfoNameNumberType(resultLabel, imageLabel);
            }

        });
    }

    public static void main(String[] args) {
        //Iniciar a Gui Pokedex
        new PokedexGUI();
    }


}
