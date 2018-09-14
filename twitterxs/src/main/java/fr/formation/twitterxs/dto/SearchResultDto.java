package fr.formation.twitterxs.dto;

import java.util.List;

public class SearchResultDto<E extends Dto> implements Dto {

    private static final long serialVersionUID = -196606179510433397L;

    private List<E> items;

    private long totalElements;

    public SearchResultDto() {
	// Default no-arg constructor
    }

    public SearchResultDto(List<E> items, long totalElements) {
	setItems(items);
	setTotalElements(totalElements);
    }

    public List<E> getItems() {
	return items;
    }

    public void setItems(List<E> items) {
	this.items = items;
    }

    public long getTotalElements() {
	return totalElements;
    }

    public void setTotalElements(long totalElements) {
	this.totalElements = totalElements;
    }

    @Override
    public String toString() {
	return "{items=" + items + ", totalElements=" + totalElements + "}";
    }
}
