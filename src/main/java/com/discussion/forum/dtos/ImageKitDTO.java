package com.discussion.forum.dtos;



import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import lombok.Data;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

@Data
public class ImageKitDTO {
    private ImageKit imageKit;



    public ImageKitDTO(String publicKey, String privateKey, String urlEndPoint) throws IOException {
        ImageKit imageKit = ImageKit.getInstance();
        Configuration config = new Configuration(publicKey, privateKey, urlEndPoint);
        imageKit.setConfig(config);
        DateRange range = getCurrentMonthRange();
        this.imageKit = imageKit;
    }

    private DateRange getCurrentMonthRange() {
        return new DateRange();
    }

    @Data
    static class DateRange {
        private String startDate;
        private String endDate;

        DateRange() {
            LocalDate now = LocalDate.now();
            this.endDate = now.with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_DATE);
            this.startDate = now.with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_DATE);
        }
    }

    @Data
    static class ImageKitUsage {
        private Long bandwidthBytes;
        private Long mediaLibraryStorageBytes;
        private Long videoProcessingUnitsCount;
        private Long extensionUnitsCount;
        private Long originalCacheStorageBytes;
    }
}
