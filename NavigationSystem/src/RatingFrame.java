import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by zamanmm on 2/17/16.
 */
public class RatingFrame extends JFrame
{
    private locationMapHash hash;
    public RatingFrame(locationMapHash hash)
    {
        this.hash = hash;
        setResizable(false);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        getContentPane().setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        concatRatings();
    }
    
    private void concatRatings()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setSize(getSize());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Font f = new Font(null, Font.PLAIN, 16);
        String ratingText = "";
        for (int i = 0; i < hash.sortByInterest().size(); i++)
        {
            String city = hash.sortByInterest().get(i);
            if (i == 0)
            {
                ratingText = ratingText + "<html><span class='left'>" + city + "&nbsp;&nbsp; = &nbsp;&nbsp;" + hash.get(city).getinterestRating() + "/10</span><br>";
            }
            else if (i == hash.sortByInterest().size() - 1)
            {
                ratingText =  ratingText + "<span class='left'>" + city + "&nbsp;&nbsp; = &nbsp;&nbsp;" + hash.get(city).getinterestRating() + "/10</span><br></html>";
            }
            else
            {
                ratingText =  ratingText + "<span class='left'>" + city + "&nbsp;&nbsp; = &nbsp;&nbsp;" + hash.get(city).getinterestRating() + "/10</span><br>";
            }
        }

        JLabel rating = new JLabel(ratingText, SwingConstants.CENTER);
        rating.setBackground(null);
        rating.setFont(f);
        rating.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rating.setForeground(Color.WHITE);

        setSize(300, hash.size()*20);
        panel.add(rating);
        rating.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel);

    }
}
