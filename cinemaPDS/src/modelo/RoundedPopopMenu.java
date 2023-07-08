package modelo;

import javax.swing.JPopupMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPopopMenu extends JPopupMenu{
	private int cornerRadius = 11;

    public RoundedPopopMenu() {
        super();
        setOpaque(true);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arcSize = cornerRadius * 2;

        Shape border = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
        g2.setColor(getBorderColor());
        g2.draw(border);

        g2.dispose();
    }

    private Color getBorderColor() {
        // Define a cor da borda do JPopupMenu (ajuste de acordo com suas preferências)
        return Color.BLACK;
    }
}
