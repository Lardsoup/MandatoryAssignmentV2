package com.example.lardman.mandatoryassignmentv2;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Lardman on 03-04-2018.
 */

public class Observation implements Serializable
{
    @SerializedName("BirdId")
    private int BirdId;
    @SerializedName("Comment")
    private String Comment;
    @SerializedName("Created")
    private String Created;
    @SerializedName("Id")
    private int Id;
    @SerializedName("Latitude")
    private String Latitude;
    @SerializedName("Longitude")
    private String Longitude;
    @SerializedName("Placename")
    private String PlaceName;
    @SerializedName("Population")
    private int Population;
    @SerializedName("UserId")
    private String UserId;
    @SerializedName("NameDanish")
    private String NameDanish;
    @SerializedName("NameEnglish")
    private String NameEnglish;

    public Observation(int birdId, String comment, String created, int id, String latitude, String longitude, String placeName,
                       int population, String userId, String nameDanish, String nameEnglish)
    {
        this.BirdId = birdId;
        this.Comment = comment;
        this.Created = created;
        this.Id = id;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.PlaceName = placeName;
        this.Population = population;
        this.UserId = userId;
        this.NameDanish = nameDanish;
        this.NameEnglish = nameEnglish;
    }

    public void setBirdId(int birdId)
    {
        this.BirdId = birdId;
    }

    public void setComment(String comment)
    {
        this.Comment = comment;
    }

    public void setCreated(String created)
    {
        this.Created = created;
    }

    public void setId(int id)
    {
        this.Id = id;
    }

    public void setLatitude(String latitude)
    {
        this.Latitude = latitude;
    }

    public void setLongitude(String longitude)
    {
        this.Longitude = longitude;
    }

    public void setPlaceName(String placeName)
    {
        this.PlaceName = placeName;
    }

    public void setPopulation(int population)
    {
        this.Population = population;
    }

    public void setUserId(String userId)
    {
        this.UserId = userId;
    }

    public void setNameDanish(String nameDanish)
    {
        this.NameDanish = nameDanish;
    }

    public void setNameEnglish(String nameEnglish)
    {
        this.NameEnglish = nameEnglish;
    }



    public int getBirdId()
    {
        return this.BirdId;
    }

    public String getComment()
    {
        return this.Comment;
    }

    public String getCreated()
    {
        return this.Created;
    }

    public int getId()
    {
        return this.Id;
    }

    public String getLatitude()
    {
        return this.Latitude;
    }

    public String getLongitude()
    {
        return this.Longitude;
    }

    public String getPlaceName()
    {
        return this.PlaceName;
    }

    public int getPopulation()
    {
        return this.Population;
    }

    public String getUserId()
    {
        return this.UserId;
    }

    public String getNameDanish()
    {
        return this.NameDanish;
    }

    public String getNameEnglish()
    {
        return this.NameEnglish;
    }
}