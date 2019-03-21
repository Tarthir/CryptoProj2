import java.util.*;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {
    private final double p_graph;
    private final double p_malicious;
    private final double p_txDistribution;
    private final int numRounds;
    private boolean[] followees;
    private Set<Transaction> pending;
    private Set<Candidate> pending_candidates;
    private Map<Integer,List<Transaction>> senders_to_trans;
    private Map<Integer,Set<Transaction>> trans_to_senders;

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
        this.p_graph = p_graph;
        this.p_malicious = p_malicious;
        this.p_txDistribution = p_txDistribution;
        this.numRounds = numRounds;
        this.senders_to_trans = new HashMap<>();
        this.trans_to_senders = new HashMap<>();
    }

    public void setFollowees(boolean[] followees) {
        this.followees = followees;
    }

    // We Are assuming all transactions are valid
    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        pending = pendingTransactions;
    }

    public Set<Transaction> sendToFollowers() {
        // TODO return transactions depending
        return pending;
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
        if(candidates != null) {
            //add candidates that come in to a list of "pending" candidates
            //this.pending_candidates.addAll(candidates);
            for (Candidate c: candidates) {
                pending.add(c.tx);
            }
            // TODO turn candidates into transactions to be sent to followers depending
        /*for (Candidate c : candidates) {
            if (senders_to_trans.containsKey(c.sender)) {
                senders_to_trans.get(c.sender).add(c.tx);
            }
            else{
                List<Transaction> ls_tx = new LinkedList<>();
                ls_tx.add(c.tx);
                senders_to_trans.put(c.sender,ls_tx);
            }*/
            //}
        }
        return;
    }
}
