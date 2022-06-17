//     <Click Counter: A simple click counter implemented in java.>
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class ClickCounter implements ActionListener {
    byte clicks = -1;
    Toolkit tools;
    Dimension screen_size;
    JFrame window;
    JButton button;
    Border border;

    ClickCounter() {
        tools = Toolkit.getDefaultToolkit();
        screen_size = tools.getScreenSize();
        int n_width = (int) screen_size.getWidth();
        int n_height = (int) screen_size.getHeight();

        border = BorderFactory.createLineBorder(Color.white);

        button = new JButton();
        button.setBounds(n_width/7, n_height/7, 100, 50);
        button.setForeground(Color.white);
        button.setBorder(border);
        button.setText("Click me");
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.addActionListener(this);

        window = new JFrame();
        window.setSize(n_width/3, n_height/3);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setTitle("Clicks Counter");
        window.getContentPane().setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        window.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicks += clicks >= 99? -99: 1;
        
        button.setText(String.format("%d", clicks));
    }
}
