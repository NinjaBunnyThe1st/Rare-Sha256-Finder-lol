import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.* ;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Main extends JFrame {
  static JButton b,
  b2;
  static JLabel[] las = new JLabel[12];
  static JFrame frame;
  static char[] as;
  static String[] lr = new String[8];
  static boolean done = false;
  static byte[] hash1;
  public static String doubleSHA256(String input) throws Exception {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    hash1 = md.digest(input.getBytes(StandardCharsets.UTF_8));
    byte[] hash2 = md.digest(hash1);
    return bytesToHex(hash2);
  }

  private static String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b: bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }
  public static void anb(Container[][] ob) {
    for (int b = 0; b < ob[0].length; b++) {
      frame.add(ob[0][b]);
    }
  }

  public static void setLas(JLabel[] lass) {
    int dis = 550;
    for (int b = 0; b < lass.length; b++) {
      lass[b] = new JLabel();
      lass[b].setFont(new Font("Monospaced", Font.PLAIN, 15));
      lass[b].setText("");
      lass[b].setBounds(0, dis, 1200, 150);
      lass[b].setVisible(true);
      dis += 20;
      lass[b].setOpaque(false);
    }
  }

  public static void createAndShowGUI() {
    ButtonListener listener = new ButtonListener();
    frame = new JFrame("Rare Sha256() finder (Sigma)");
    ImageIcon con = new ImageIcon(".//res//icon.png");
    frame.setIconImage(con.getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLas(las);
    las[0].setText("Click the blue button to start...");
    las[1].setText("Latest 16:");
    las[2].setText("Latest 256:");
    las[3].setText("Latest 4096:");
    las[4].setText("Lastest 4096 Input:");
    las[5].setText("Latest 65536:");
    las[6].setText("Lastest 65536 Input:");
    las[7].setText("Latest 1048576:");
    las[8].setText("Lastest 1048576 Input:");
    las[9].setText("Latest 16777216:");
    las[10].setText("Latest 16777216 Input:");
    las[11].setText("The terminal will print rare sha256() while running (if you get some ofc)");
    b = new JButton();
    b.setBounds(150, 50, 400, 400);
    b.addActionListener(listener);
    b.setBackground(Color.GREEN);
    b.setText("Start");
    b2 = new JButton();
    b2.setBounds(700, 50, 400, 400);
    b2.addActionListener(listener);
    b2.setBackground(Color.BLUE);
    b2.setText("Stop");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(1200, 1000);
    frame.setVisible(true);
    frame.setResizable(false);
    Container[][] obs = {
      las
    };
    anb(obs);
    frame.add(b);
    frame.add(b2);
  }
  public static void main(String[] args) throws Exception {
    as = new char[128];
    for (int i = 0; i < 128; i++) {
      as[i] = (char) i;
    }
    SwingUtilities.invokeLater(Main::createAndShowGUI);
  }
  private static SwingWorker < Void,
  Void > worker;
  public static void startLongProcess() {
    worker = new SwingWorker < Void,
    Void > () {@Override
      protected Void doInBackground() throws Exception {

        int[] secs = new int[6];
        int[] tims = {
          1,
          1,
          1,
          1,
          1,
          1
        };
        final long ss = System.currentTimeMillis();
        Font s4f = las[0].getFont().deriveFont(4f);
        las[0].setFont(s4f);
        while (!done) {
          long sss = System.currentTimeMillis();
          int s = ((int)(sss - ss) / 10);
          int sec = s / 100;
          String im = "";
          double amount = Math.floor(Math.random() * 64);
          if (amount == 0) {
            im = "lol";
          }
          for (double b = 0; b < amount; b++) {
            int in =(int)(double) Math.floor(Math.random() * 128);
            String th = Character.toString(as[ in ]);
            im = im + th;
          }
          String input = String.valueOf(im);
          String res = doubleSHA256(input);
          StringBuilder binaryBuilder = new StringBuilder();
          for (char c: input.toCharArray()) {
            binaryBuilder.append(Integer.toBinaryString(c));
          }
          StringBuilder hexBuilder = new StringBuilder();
          for (byte b: hash1) {
            hexBuilder.append(String.format("%02X", b));
          }
          String hash = hexBuilder.toString().toLowerCase();
          String inp = binaryBuilder.toString();
          las[0].setText("Latest Input: " + inp);
          int rar = getRarity(res);
          switch (rar) {
          case 2:
            las[1].setText("Latest 16: " + lr[2] + " Time: " + (s - secs[0]) + "mms");
            secs[0] = s;
            break;
          case 3:
            las[2].setText("Latest 256: " + lr[3] + " Time: " + ((s / 10) - secs[1]) + "ms" + " Amount " + tims[1]);
            secs[1] = s / 10;
            tims[1]++;
            break;
          case 4:
            las[3].setText("Latest 4096: " + lr[4] + " Time: " + (sec - secs[2]) + "s" + " Amount " + tims[2]);
            secs[2] = sec;
            tims[2]++;
            las[4].setText("Lastest 4096 Input: " + hash);
            break;
          case 5:
            las[5].setText("Latest 65536: " + lr[5] + " Time: " + (sec - secs[3]) + "s" + " Amount " + tims[3]);
            secs[3] = sec;
            tims[3]++;
            las[6].setText("Lastest 65536 Input: " + hash);
            pr("1/65536 Sha256: " + hash);
            break;
          case 6:
            las[7].setText("Latest 1048576: " + lr[6] + " Time: " + (sec - secs[4]) + "s" + " Amount " + tims[4]);
            secs[4] = sec;
            tims[4]++;
            las[8].setText("Lastest 1048576 Input: " + hash);
            pr("1/1048576 Sha256: " + hash);
            break;
          case 7:
            las[9].setText("Latest 16777216: " + lr[7] + " Time: " + (sec - secs[5]) + "s" + " Amount " + tims[5]);
            secs[5] = sec;
            tims[5]++;
            las[10].setText("Lastest 16777216 Input: " + hash);
            pr("1/16777216 Sha256: " + hash);
            break;
          default:
            break;
          }
        if(rar>=8){pr("Jackpot, 1/??? Sha256: " + hash);}
        }
        return null;

      }
      private void pr(String inp) {
        System.out.println(inp);
      }
      protected void done() {
        b.setEnabled(true);
      }

    };
    worker.execute();
  }
  public static int getRarity(String r) {
    int rarity = 0;
    String lz = "0";
    for (int b = 1; b < r.length(); b++) {
      if (r.substring(0, b).equals(lz)) {
        rarity++;
        lz = lz + "0";
      } else {
        lr[b] = r.substring(0, b + 1);
        break;
      }
    };
    return rarity;
  }

  private static class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == b) {
        b.setEnabled(false);
        done = false;
        b.setBackground(Color.RED);
        b.setFont(b.getFont().deriveFont(20f));
        b.setText("");
        try {
          startLongProcess();
        } catch(Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == b2) {
        done = true;
        b.setEnabled(true);
      }
    }

  }
}