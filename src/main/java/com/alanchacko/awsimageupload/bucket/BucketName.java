package com.alanchacko.awsimageupload.bucket;

public enum BucketName {
    PROFILE_IMAGE("aws-image-upload-springboot-demo");
    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
