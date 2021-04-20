package io.zipcoder.tc_spring_poll_application.dto;

import sun.text.resources.CollationData;

import java.util.Collection;

public class VoteResult {

    private int totalVotes;
    private Collection<OptionCount> results;

    public VoteResult() {}

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Collection<OptionCount> getResults() {
        return results;
    }

    public void setResults(Collection<OptionCount> results) {
        this.results = results;
    }
}
