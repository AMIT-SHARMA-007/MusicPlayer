package MusicPlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Panels extends JFrame {
	int index;
	boolean isPlaying = false, started = false;
	Music m = new Music();

	JPanel Playlist(int w, int h) {

		getContentPane().setLayout(getLayout());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		String[] pLists = { "Recently Added", "Recently Played" };
		String[] s = { "a", "b" };

		JList<String> list = new JList<String>(pLists);
		JList<String> list1 = new JList<String>(s);
		JScrollPane scroll = new JScrollPane(list);
		JScrollPane scroll1 = new JScrollPane(list1);
		scroll.setPreferredSize(new Dimension((int) (w * 0.3), h));
		scroll1.setPreferredSize(new Dimension((int) (w * 0.65), h));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(scroll);
		panel.add(scroll1);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		return panel;

	}

	JPanel Library(int w, int h) {
		getContentPane().setLayout(new BorderLayout(0, 0));
		String[] s = { "a", "b" };
		JList<String> list = new JList<String>(s);
		JPanel panel = new JPanel();
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension((int) (w * 0.9), h));
		getContentPane().setLayout(getLayout());
		panel.add(scroll);

		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);

				// TODO Auto-generated method stub

				JList l = (JList) e.getSource();
				if (e.getClickCount() == 2) {
					index = l.locationToIndex(e.getPoint());

					m.play(index);
					isPlaying = true;
					started = true;
				}

			}
			// public void mouseExit(MouseEvent e){
			// super.mouseExited(e);
			// stop t = new stop();
			// t.run(e);
			// }

		});
		return panel;
	}

	JPanel Bar() {

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		JButton btnPrevious = new JButton("Previous");
		panel.add(btnPrevious);

		JButton btnPlaypause = new JButton("Play/Pause");
		panel.add(btnPlaypause);

		JButton btnNext = new JButton("Next");
		panel.add(btnNext);

		JButton btnStop = new JButton("Stop");
		panel.add(btnStop);
		
		btnStop.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try{
					m.stop();
					isPlaying = false;
					started = false;
				}
				catch(Exception ee){
					
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		btnPlaypause.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (isPlaying == false && started == false) {
					m.play(0);
					isPlaying = true;
					started = true;
				} else if(isPlaying == true){
					m.pause();
					isPlaying = false;
				} else if(isPlaying == false && started == true){
					isPlaying = true;
					m.resume();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnPrevious.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

				if (index > 0) {
					index--;
				} else {
					index++;
				}
				m.play(index);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnNext.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (index > 0) {
					index--;
				} else {
					index++;
				}
				m.play(index);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return panel;
	}
}
