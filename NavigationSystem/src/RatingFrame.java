import javax.swing.*;
import javax.swing.border.BevelBorder;
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
        setSize(210, 640);
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
        for (String city: hash.sortByInterest())
        {
            JLabel rating = new JLabel(city + " " + hash.get(city).getinterestRating() + "/10", SwingConstants.CENTER);
            rating.setBackground(null);
            rating.setBorder(new BevelBorder(BevelBorder.RAISED));
            rating.setForeground(Color.WHITE);
            panel.add(rating);
            rating.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        add(panel);

    }
}
