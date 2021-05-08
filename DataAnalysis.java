package org.kl;

import java.io.IOException;

import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;
public class DataAnalysis {
public static void main(String args[])
{
	System.out.println("data Analysis");
	try
	{
	Table bank_data= Table.read().csv("D:\\eclipse-workspace\\org.kl\\src\\main\\java\\org\\kl\\fraud_dataset.csv");
	System.out.println(bank_data.shape());
	System.out.println(bank_data.first(7));
	System.out.println(bank_data.structure());
	
	System.out.println(bank_data.summary());
	Layout layout1 = Layout.builder().title("Distribution of Loan Amount").build();
	HistogramTrace trace1 = HistogramTrace.builder(bank_data.nCol("LoanAmount")).build();
	Plot.show(new Figure(layout1, trace1));

	Layout layout2 = Layout.builder().title("Box plot of Loan Amount").build();
	BoxTrace trace2 =BoxTrace.builder(bank_data.categoricalColumn("Fraud_Risk"),
			bank_data.nCol("LoanAmount")).build();
	Plot.show(new Figure(layout2, trace2));
	  
	}
catch(IOException e)
	{
	e.printStackTrace();
	}
}
}
