package com.studerb.hr.model;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Link {

    protected String relationship;
    protected String href;
    protected String type;

    public Link() {}

    public Link(String relationship, String href, String type) {
        this.relationship = relationship;
        this.href = href;
        this.type = type;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append(this.href).append(">; rel=").append(this.relationship);
        if (this.type != null)
            builder.append("; type=").append(this.type);
        return builder.toString();
    }

    private static Pattern parse = Pattern.compile("<(.+)>\\s*;\\s*(.+)");

    /**
     * For unmarshalling Link Headers. Its not an efficient or perfect algorithm
     * and does make a few assumptiosn
     * 
     * @param val
     * @return
     */
    public static Link valueOf(String val) {
        Matcher matcher = parse.matcher(val);
        if (!matcher.matches()) {
            throw new RuntimeException("Failed to parse link: " + val);
        }
        Link link = new Link();
        link.href = matcher.group(1);
        String[] props = matcher.group(2).split(";");
        HashMap<String, String> map = new HashMap();

        for (String prop : props) {
            String[] split = prop.split("=");
            map.put(split[0].trim(), split[1].trim());
        }

        if (map.containsKey("rel")) {
            link.relationship = map.get("rel");
        }
        if (map.containsKey("type")) {
            link.type = map.get("type");
        }
        return link;
    }
}
