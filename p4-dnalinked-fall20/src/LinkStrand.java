public class LinkStrand implements IDnaStrand{

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    //For char at
    private int myIndex;
    private int myLocalIndex;
    private Node myCurrent;

    /**
     * The Node objects that make up a LinkStrand
     */
    private class Node {
        String info;
        Node next;

        public Node(String s) {
            info = s;
            next = null;
        }
    }

    /**
     * Create LinkStrand representing s
     * @param s cgat data the LinkStrand will contain
     */
    public LinkStrand(String s) {
        initialize(s);
    }

    public LinkStrand() {
        this("");
    }

    /**
     *
     * @return number of base pairs in LinkStrand
     */
    @Override
    public long size() {
        return mySize;
    }

    /**
     * Initialize the LinkStrand to contain the same data as source. Also sets instance variables
     * to the correct starting values.
     * @param source the source of the enzyme
     */
    @Override
    public void initialize(String source) {
        this.myFirst = new Node(source);
        this.myLast = myFirst;
        this.mySize = source.length();
        this.myAppends = 0;
        this.myCurrent = myFirst;
        this.myIndex = 0;
        this.myLocalIndex = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    /**
     * Append a new strand of DNA to the LinkStrand
     * @param dna is the string appended to this strand
     * @return this modified LinkStrand object
     */
    @Override
    public IDnaStrand append(String dna) {
        this.mySize = mySize + dna.length();
        this.myAppends++;
        Node n = new Node(dna);
        this.myLast.next = n;
        this.myLast = myLast.next;
        return this;
    }

    /**
     * Reverse the nodes of the LinkStrand as well as the String contents of the nodes
     * @return new reversed LinkStrand
     */
    @Override
    public IDnaStrand reverse() {
        Node i = this.myFirst;
        String toRev = i.info;
        StringBuilder sb = new StringBuilder(toRev);
        StringBuilder sbRev = sb.reverse();
        LinkStrand res = new LinkStrand(sbRev.toString());
        i = i.next;
        while (i != null) {
            toRev = i.info;
            sb = new StringBuilder(toRev);
            sbRev = sb.reverse();
            Node temp = new Node(sbRev.toString());
            temp.next = res.myFirst;
            res.myFirst = temp;
            res.mySize = res.mySize + temp.info.length();
            i = i.next;
        }
        return res;
    }

    /**
     *
     * @return number of appends called
     */
    @Override
    public int getAppendCount() {
        return this.myAppends;
    }

    /**
     * Gets char at given index, also saves state with instance variables - if index given in next
     * call > previous index then will scan from previous index rather than from 0.
     * @param index specifies which character will be returned
     * @return character at given index of LinkStrand
     */
    @Override
    public char charAt(int index) {
        if (index < 0 || index >= mySize) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index < this.myIndex) {
                this.myIndex = 0;
                this.myLocalIndex = 0;
                this.myCurrent = myFirst;
            }
            while (this.myIndex != index) {
                this.myIndex++;
                this.myLocalIndex++;
                if (this.myLocalIndex >= this.myCurrent.info.length()) {
                    this.myLocalIndex = 0;
                    this.myCurrent = this.myCurrent.next;
                }
            }
            return this.myCurrent.info.charAt(this.myLocalIndex);
        }
    }

    /**
     * Combines all characters of all nodes in LinkStrand w/ StringBuilder
     * @return String of contents of LinkStrand object
     */
    @Override
    public String toString() {
        Node index = this.myFirst;
        StringBuilder sb = new StringBuilder();
        while (index != null) {
            sb.append(index.info);
            index = index.next;
        }
        return sb.toString();
    }
}