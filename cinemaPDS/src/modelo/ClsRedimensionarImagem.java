package modelo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ClsRedimensionarImagem {
	 /*
     * @param receber icone, largura e altura desejeda
     * @return retorna a imagem redimensionada
     */
    public ImageIcon redimensionar(JLabel jLabel, int xLargura, int yAltura){
       
        ImageIcon img = new ImageIcon (jLabel.getIcon().toString());  
        img.setImage(img.getImage().getScaledInstance(xLargura, yAltura, 100));
       
        return img;
    }
}
