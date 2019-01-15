package fr.formation.twitterxs.dto;

public class CacheDto implements Dto {

    private static final long serialVersionUID = 7816079858478658669L;

    private long putCount;

    private long hitCount;

    private long missCount;

    public CacheDto() {
	// Default no-arg constructor
    }

    public long getPutCount() {
	return putCount;
    }

    public void setPutCount(long userPuts) {
	putCount = userPuts;
    }

    public long getHitCount() {
	return hitCount;
    }

    public void setHitCount(long userHits) {
	hitCount = userHits;
    }

    public long getMissCount() {
	return missCount;
    }

    public void setMissCount(long userMissed) {
	missCount = userMissed;
    }
}
