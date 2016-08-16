package es.asauth.domain;

public enum Role {
    PUBLISHER("Publisher"), ADMIN("Admin");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
