package com.wallellen.test.storm;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/18/16.
 */
public class DoubleAndTripleBolt extends BaseRichBolt {
    private OutputCollector _outputCollector = null;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this._outputCollector = outputCollector;
    }

    @Override
    public void execute(Tuple input) {
        int val = input.getInteger(0);
        _outputCollector.emit(input, new Values(val * 2, val * 3));
        _outputCollector.ack(input);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("double", "triple"));
    }
}
