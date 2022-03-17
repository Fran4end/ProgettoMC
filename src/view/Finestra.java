package view;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

import model.scacchiera.Scacchiera;
public class Finestra {

    private Scacchiera sca;

    private JFrame frame;
    private JPanel mainPanel;
    private final Font mainFont = new Font("Sogoe print", Font.BOLD, 18);

    public Finestra(Scacchiera sca) {
        this.sca = sca;

        frame = new JFrame();
        setupUI();
        frame.add(mainPanel);
        frame.setTitle("Progetto MC");
        frame.setMinimumSize(new Dimension(500, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try {
            resizeFile(".\\src\\view\\seta.jpg", ".\\src\\view\\seta1.png", 100, 100);
            resizeFile(".\\src\\view\\energia.png", ".\\src\\view\\energia1.png", 100, 100);
            resizeFile(".\\src\\view\\agente.jpg", ".\\src\\view\\agente1.jpg", 100, 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private void setupUI(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        /** 
         * * Pannello Statistiche 
         */
        JLabel firstPlayer = new JLabel();
        firstPlayer.setFont(mainFont);
        firstPlayer.setText("Primo giocatore");

        JLabel secondPlayer = new JLabel();
        secondPlayer.setFont(mainFont);
        secondPlayer.setText("Secondo giocatore");

        JLabel thirdPlayer = new JLabel();
        thirdPlayer.setFont(mainFont);
        thirdPlayer.setText("Terzo giocatore");

        JPanel classifica = new JPanel();
        classifica.setLayout(new GridLayout(3, 1, 5, 5));
        classifica.add(firstPlayer);
        classifica.add(secondPlayer);
        classifica.add(thirdPlayer);

        JLabel turni = new JLabel();
        turni.setFont(mainFont);
        turni.setText("Numero di turni");

        JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();

        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new GridLayout(1, 3, 5, 5));
        statisticsPanel.add(classifica);
        statisticsPanel.add(toolBar$Separator1);
        statisticsPanel.add(turni);

        /**
         *  *Pannello Scacchiera
         */
        //working in progress
        JPanel scacc = new JPanel(){
            public void paint(Graphics g){
                ImageIcon img;
                for(int i = 0; i < sca.getLenx(); i++){
                    for(int j = 0; j < sca.getLeny(); j++){
                        g.setColor(Color.BLACK);
                        if(sca.getCasella(i, j).getInfo().equals("vuota")){
                            g.drawRect(i*5, j*5, 100, 100);  
                            //tab += "|x|";
                        }else if(sca.getCasella(i, j).getInfo().contains("Seta")){
                            img = new ImageIcon(".\\src\\view\\seta1.png");
                            g.drawImage( img.getImage(), i*5, j*5, 100, 100, null);    
                            //tab += "|S|";
                        }else if(sca.getCasella(i, j).getInfo().contains("Energia")){
                            img = new ImageIcon(".\\src\\view\\energia1.png");
                            g.drawImage( img.getImage(), i*5, j*5, 100, 100, null);    
                            //tab += "|E|"; 
                        }else{
                            img = new ImageIcon(".\\src\\view\\agente1.png");
                            g.drawImage( img.getImage(), i*5, j*5, 100, 100, null);
                            //tab += "|O|";
                        }
                            
                    }
                }
            }
        };
        JTextArea OutPut = new JTextArea();
        OutPut.append(sca.toString());
        OutPut.setEditable(false);
        
        JScrollPane scrollPane1 = new JScrollPane(scacc);
        scrollPane1.setEnabled(true);

        /**
         * * Pannello Principale
         */
        mainPanel.add(statisticsPanel, BorderLayout.PAGE_END);
        mainPanel.add(scacc, BorderLayout.CENTER);
    }

    private static void resizeFile(String imagePathToRead,
                              String imagePathToWrite, int resizeWidth, int resizeHeight)
            throws IOException {

        File fileToRead = new File(imagePathToRead);
        BufferedImage bufferedImageInput = ImageIO.read(fileToRead);

        BufferedImage bufferedImageOutput = new BufferedImage(resizeWidth,
                resizeHeight, bufferedImageInput.getType());

        Graphics2D g2d = bufferedImageOutput.createGraphics();
        g2d.drawImage(bufferedImageInput, 0, 0, resizeWidth, resizeHeight, null);
        g2d.dispose();

        String formatName = imagePathToWrite.substring(imagePathToWrite
                .lastIndexOf(".") + 1);

        ImageIO.write(bufferedImageOutput, formatName, new File(imagePathToWrite));
    }

}
