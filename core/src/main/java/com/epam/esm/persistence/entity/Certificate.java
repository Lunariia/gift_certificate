package com.epam.esm.persistence.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

public class Certificate {

    @NotNull(message = "Id cannot be null")
    @Size(min = 1, message = "Id should be more than zero")
    private final Long id;

    @NotNull(message = "Name cannot be null")
    @Size(max = 150, message = "Name should be less than 150")
    @NotEmpty(message = "Name cannot be null")
    private final String name;

    @NotNull(message = "Description cannot be null")
    @Size(max = 255, message = "Description should be less than 255")
    @NotEmpty(message = "Description cannot be null")
    private final String description;

    @NotNull(message = "Price cannot be null")
    @Size(min = 0, max = 99999, message = "Price should not be less than zero")
    private final BigDecimal price;

    @NotNull(message = "Duration cannot be null")
    @Size(min = 1, message = "Duration should be more than zero")
    private final Integer duration;

    @NotNull(message = "CreateDate cannot be null")
    private final LocalDateTime createDate;

    @NotNull(message = "LastUpdateDate cannot be null")
    private final LocalDateTime lastUpdateDate;

    @NotNull(message = "Tags cannot be null")
    @Valid
    private final Set<Tag> tags;

    public Certificate(Long id,
                       String name,
                       String description,
                       BigDecimal price,
                       Integer duration,
                       LocalDateTime createDate,
                       LocalDateTime lastUpdateDate,
                       Set<Tag> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getDuration() {
        return duration;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Set<Tag> getTags() {
        return tags == null ? null : Collections.unmodifiableSet(tags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Certificate that = (Certificate) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                price.equals(that.price) &&
                duration.equals(that.duration) &&
                createDate.equals(that.createDate) &&
                lastUpdateDate.equals(that.lastUpdateDate) &&
                tags.equals(that.tags);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", tags=" + tags +
                '}';
    }

    public static final class Builder {

        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer duration;
        private LocalDateTime createDate;
        private LocalDateTime lastUpdateDate;
        private Set<Tag> tags;

        public Builder() {
        }

        private Builder(Certificate certificate) {
            id = certificate.id;
            name = certificate.name;
            description = certificate.description;
            price = certificate.price;
            duration = certificate.duration;
            createDate = certificate.createDate;
            lastUpdateDate = certificate.lastUpdateDate;
            tags = certificate.tags;
        }

        public static Builder from(Certificate certificate) {
            return new Builder(certificate);
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Builder setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder setLastUpdateDate(LocalDateTime lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public Builder setTags(Set<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public Certificate build() {
            return new Certificate(
                    id,
                    name,
                    description,
                    price,
                    duration,
                    createDate,
                    lastUpdateDate,
                    tags);
        }
    }

    public static final class Field {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String PRICE = "price";
        public static final String DURATION = "duration";
        public static final String CREATE_DATE = "createDate";
        public static final String LAST_UPDATE_DATE = "lastUpdateDate";
        public static final String TAGS = "tags";

    }
}
