import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Sets up Interest Rating frame for user viewing
 */
public class RatingFrame extends JFrame
{
    private locationMapHash hash;
    
    public RatingFrame(locationMapHash hash)
    {

    	
        this.hash = hash;
        
        int verticalSize = hash.size * 22;
        int horizontalSize = 400;
        Dimension size = new Dimension(horizontalSize, verticalSize);
        
        getContentPane().setBackground(Color.gray);
        setMinimumSize(size);
        pack();
        setResizable(true);
        setTitle("Interest Rating (0-10)");
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
        panel.setSize(getSize());
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new BevelBorder(BevelBorder.RAISED));
        
        JLabel title = new JLabel("Interest Rating");
        title.setBorder(new BevelBorder(BevelBorder.RAISED));
        title.setForeground(Color.cyan);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);
        
        for (String city: hash.sortByInterest())
        {
            JLabel rating = new JLabel(city + ": " + hash.get(city).getinterestRating(), SwingConstants.CENTER);
            rating.setBackground(null);
            rating.setBorder(new BevelBorder(BevelBorder.RAISED));
            rating.setForeground(Color.WHITE);
            panel.add(rating);
            rating.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        add(panel);

    }
}
