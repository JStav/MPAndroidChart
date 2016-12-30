package com.xxmassdeveloper.mpchartexample;
import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LimitLineActivity extends DemoBase {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_limit_line);

    LineChart chart = (LineChart) findViewById(R.id.limit_line_chart);

    List<Entry> entries = new ArrayList<>();

    for(int i = 0; i < 10; i++) {

      Entry entry = new Entry(i, new Random().nextInt(9));
      entries.add(entry);

      if(i % 2 == 0) {
        LimitLine line = new LimitLine(i, String.valueOf(i));
        line.setLabelPosition(LimitLine.LimitLabelPosition.CENTER_BOTTOM);
        line.setTextSize(16f);
        chart.getXAxis().addLimitLine(line);
      }

    }

    LineDataSet set = new LineDataSet(entries, "");
    set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
    set.setLineWidth(2f);

    LineData data = new LineData(set);
    data.setDrawValues(false);

    chart.getAxisRight().setEnabled(false);
    chart.getXAxis().setDrawLabels(false);
    chart.getXAxis().setDrawGridLines(false);

    Description description = new Description();
    description.setText("");

    chart.getLegend().setEnabled(false);
    chart.setDescription(description);
    chart.setData(data);
    chart.invalidate();
  }
}
