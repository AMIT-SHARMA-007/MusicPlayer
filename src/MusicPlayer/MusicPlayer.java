package MusicPlayer;

import java.awt.BorderLayout;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MusicPlayer extends Application{

	static int w, h;
	public static void main(String[] args) {
		window1 window = new window1();

		JFrame frame = window.frame();
		frame.setSize(500, 300);
		frame.setVisible(true);
		Panels panel = new Panels();

		w = frame.getContentPane().getWidth();
		h = frame.getContentPane().getHeight();

		JPanel bar_panel = panel.Bar();
		JPanel tabbed_playlist = panel.Playlist(w,h);
		
//		JPanel tabbed_playlist_panel = panel.PlaylistPanel(w,h);
//		tabbed_playlist.add(tabbed_playlist_panel);
		frame.getContentPane().add(bar_panel, BorderLayout.NORTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.addTab("Playlist", tabbed_playlist);
		tabbedPane.addTab("Library", panel.Library(w,h));
		Application.launch();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
