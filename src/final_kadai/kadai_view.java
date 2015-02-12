package final_kadai;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class kadai_view extends Frame implements WindowListener{
	
	public kadai_view(){
		
	addWindowListener(this);
	setTitle("ƒKƒ\ƒŠƒ“‚Ì‰¿Ši");
	
	DefaultCategoryDataset data = new DefaultCategoryDataset();
	
	int date;
	double price;
	ResultSet rs;
	
	MySQL mysql = new MySQL();
	rs = mysql.selectAll();
	
	try {
		while(rs.next()){
			date = rs.getInt("date");
			price = rs.getDouble("price");
			
			data.addValue(price,"" , ""+date);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	JFreeChart chart = 
		      ChartFactory.createLineChart("the price of gasoline",
		                                   "date",
		                                   "price",
		                                   data,
		                                   PlotOrientation.VERTICAL,
		                                   true,
		                                   false,
		                                   false);

		    ChartPanel cpanel = new ChartPanel(chart);
		    add(cpanel, BorderLayout.CENTER);
		


}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}