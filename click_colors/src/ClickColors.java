//     <Click Colors: Click and the colors of the window change>
//     Copyright (C) <2022>  <Cromega>

//     This program is free software: you can redistribute it and/or modify
//     it under the terms of the GNU Affero General Public License as published
//     by the Free Software Foundation, either version 3 of the License, or
//     (at your option) any later version.

//     This program is distributed in the hope that it will be useful,
//     but WITHOUT ANY WARRANTY; without even the implied warranty of
//     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//     GNU Affero General Public License for more details.

//     You should have received a copy of the GNU Affero General Public License
//     along with this program.  If not, see <https://www.gnu.org/licenses/>.

import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class ClickColors implements ActionListener{
    Border border;
    Color main, second, third, contrast;
    JButton button;
    JLabel layout;
    JFrame window;

    ClickColors() {
        main = new Color(0x2E0249);
        second = new Color(0x570A57);
        third = new Color(0xA91079);
        contrast = new Color(0xF806CC);

        border = BorderFactory.createLineBorder(third);

        button = new JButton();
        button.addActionListener(this);
        button.setBounds(50, 50, 100, 100);;
        button.setText("X");
        button.setForeground(contrast);
        button.setBorder(border);
        button.setFocusable(false);
        button.setContentAreaFilled(false);

        layout = new JLabel();
        layout.setBounds(150, 125, 200, 200);
        layout.setBackground(second);
        layout.add(button);
        layout.setOpaque(true);

        window = new JFrame();
        window.setSize(500, 500);
        window.setResizable(false);
        window.getContentPane().setBackground(main);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        window.add(layout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color current = window.getContentPane().getBackground();

        if (current == main) {
            window.getContentPane().setBackground(second);
            layout.setBackground(third);
            border = BorderFactory.createLineBorder(contrast);
            button.setBorder(border);
            button.setForeground(main);
        }

        if (current == second) {
            window.getContentPane().setBackground(third);
            layout.setBackground(contrast);
            border = BorderFactory.createLineBorder(main);
            button.setBorder(border);
            button.setForeground(second);
        }

        if (current == third) {
            window.getContentPane().setBackground(contrast);
            layout.setBackground(main);
            border = BorderFactory.createLineBorder(second);
            button.setBorder(border);
            button.setForeground(third);
        }

        if (current == contrast) {
            window.getContentPane().setBackground(main);
            layout.setBackground(second);
            border = BorderFactory.createLineBorder(third);
            button.setBorder(border);
            button.setForeground(contrast);
        }
    }
}
