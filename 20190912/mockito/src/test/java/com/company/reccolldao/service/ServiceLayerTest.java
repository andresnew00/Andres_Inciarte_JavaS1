package com.company.reccolldao.service;

import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ServiceLayer service;
    AlbumDao albumDao;
    ArtistDao artistDao;

    LabelDao labelDao;

    TrackDao trackDao;

    @Before
    public void setUp() throws Exception {
        setUpAlbumDaoMock();
        setUpArtistDaoMock();
        setUpLabelDaoMock();
        setUpTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);

    }

// Helper methods

    private void setUpAlbumDaoMock() {
        albumDao = mock(AlbumDaoJdbcTemplateImpl.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumDao).addAlbum(album2);
        doReturn(album).when(albumDao).getAlbum(1);
        doReturn(aList).when(albumDao).getAllAlbums();
    }

    private void setUpArtistDaoMock() {
        //reflections (read into)
        artistDao = mock(ArtistDaoJdbcTemplateImpl.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = new Artist();
        artist2.setInstagram("@RockStar");
        artist2.setName("The GOAT");
        artist2.setTwitter("@TheRockStar");

        List<Artist> aList = new ArrayList();
        aList.add(artist);

        doReturn(artist).when(artistDao).addArtist(artist2);
        doReturn(artist).when(artistDao).getArtist(45);
        doReturn(aList).when(artistDao).getAllArtists();
    }

    private void setUpLabelDaoMock() {
        labelDao = mock(LabelDaoJdbcTemplateImpl.class);
        Label label = new Label();
        label.setId(10);
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        Label label2 = new Label();
        label2.setName("Blue Note");
        label2.setWebsite("www.bluenote.com");

        List<Label> lList = new ArrayList<>();
        lList.add(label);

        doReturn(label).when(labelDao).addLabel(label2);
        doReturn(label).when(labelDao).getLabel(10);
        doReturn(lList).when(labelDao).getAllLabels();
    }

    private void setUpTrackDaoMock() {
        trackDao = mock(TrackDaoJdbcTemplateImpl.class);
        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        Track track2 = new Track();
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        List<Track> tList = new ArrayList<>();
        tList.add(track);

        doReturn(track).when(trackDao).addTrack(track2);
        doReturn(track).when(trackDao).getTrack(1);
        doReturn(tList).when(trackDao).getAllTracks();
        doReturn(tList).when(trackDao).getTracksByAlbum(1);
    }

    //   savefindfindall

    @Test
    public void saveFindFindAllLabel(){
        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        label = service.saveLabel(label);
        Label fromService = service.findLabel(label.getId());
        assertEquals(label, fromService);

        List<Label> lList = service.findAllLabels();
        assertEquals(1, lList.size());
        assertEquals(label, lList.get(0));
    }

    @Test
    public void SaveFindFindAllAlbum() {
        AlbumViewModel avm = new AlbumViewModel();
        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));
        avm.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);
        avm.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);
        avm.setLabel(label);

        Track track = new Track();
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        List<Track> tList = new ArrayList<>();
        tList.add(track);
        avm.setTracks(tList);
        avm = service.saveAlbum(avm);
        AlbumViewModel fromService = service.findAlbum(avm.getId());

        assertEquals(avm, fromService);
    }

    @Test
    public void saveFindFindAllArtist() {

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        artist = service.saveArtist(artist);
        Artist fromService = service.findArtist(artist.getId());
        assertEquals(artist, fromService);

        List<Artist> aList = service.findAllArtists();
        assertEquals(1, aList.size());
        assertEquals(artist, aList.get(0));
    }

    //update

    @Test
    public void testUpdateAlbum() {

        //we use this because album is a collection of different object properties
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(1);
        avm.setListPrice(new BigDecimal("15.99"));
        avm.setReleaseDate(LocalDate.of(1999, 04, 17));
        avm.setTitle("Greatest Hits vol 2");

        Artist artist = new Artist();
        artist.setId(45);

        avm.setArtist(artist);

        Label label = new Label();
        label.setId(10);

        avm.setLabel(label);

        ArgumentCaptor<Album> albumCaptor = ArgumentCaptor.forClass(Album.class);
        doNothing().when(albumDao).updateAlbum(albumCaptor.capture());
        service.updateAlbum(avm);

        verify(albumDao,times(1)).updateAlbum(albumCaptor.getValue());

        Album album = albumCaptor.getValue();

        assertEquals(1,album.getId());
        assertEquals(avm.getListPrice(),album.getListPrice());
        assertEquals(avm.getReleaseDate(),album.getReleaseDate());
        assertEquals(avm.getTitle(),album.getTitle());

    }

    @Test
    public void updateArtist() {
        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = service.saveArtist(artist);

        ArgumentCaptor<Artist> artistArgumentCaptor = ArgumentCaptor.forClass(Artist.class);

        doNothing().when(artistDao).updateArtist(artistArgumentCaptor.capture());

        service.updateArtist(artist2);
        verify(artistDao,times(1)).updateArtist(artistArgumentCaptor.getValue());

        Artist theArtist = artistArgumentCaptor.getValue();

        assertEquals(artist2, theArtist);
        assertEquals(artist2.getId(), theArtist.getId());

    }

    @Test
    public void updateLabel() {
        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        Label label2 = service.saveLabel(label);

        ArgumentCaptor<Label> labelArgumentCaptor = ArgumentCaptor.forClass(Label.class);

        doNothing().when(labelDao).updateLabel(labelArgumentCaptor.capture());
        service.updateLabel(label2);
        verify(labelDao, times(1)).updateLabel(labelArgumentCaptor.getValue());

        Label theLabel = labelArgumentCaptor.getValue();

        assertEquals(label2, theLabel);
        assertEquals(label2.getId(),theLabel.getId());
    }

    //delete

    @Test
    public void deleteLabel(){

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(labelDao).deleteLabel(integerCaptor.capture());
        service.removeLabel(10);
        verify(labelDao, times(1)).deleteLabel(integerCaptor.getValue());

        assertEquals(10,integerCaptor.getValue().intValue());

    }

    @Test
    public void deleteArtist(){

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(artistDao).deleteArtist(integerCaptor.capture());
        service.removeArtist(45);
        verify(artistDao, times(1)).deleteArtist(integerCaptor.getValue());

        assertEquals(45,integerCaptor.getValue().intValue());

    }

    @Test
    public void deleteAlbum(){

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(albumDao).deleteAlbum(integerCaptor.capture());
        service.removeAlbum(1);
        verify(albumDao, times(1)).deleteAlbum(integerCaptor.getValue());

        assertEquals(1,integerCaptor.getValue().intValue());

    }

    //save album (in class)
//    @Test
//    public void saveAlbum() {
//        AlbumViewModel avm = new AlbumViewModel();
//
//        avm.setListPrice(new BigDecimal("14.99"));
//        avm.setReleaseDate(LocalDate.of(1999, 05, 15));
//        avm.setTitle("Greatest Hits");
//
//        Artist artist = new Artist();
//        artist.setInstagram("@RockStar");
//        artist.setName("The GOAT");
//        artist.setTwitter("@TheRockStar");
//        artist = service.saveArtist(artist);
//
//        avm.setArtist(artist);
//
//        Label label = new Label();
//        label.setName("Blue Note");
//        label.setWebsite("www.bluenote.com");
//        label = service.saveLabel(label);
//
//        avm.setLabel(label);
//
//        Track track = new Track();
//        track.setRunTime(180);
//        track.setTitle("Number 1 Hit!");
//        List<Track> tList = new ArrayList<>();
//        tList.add(track);
//
//        avm.setTracks(tList);
//
//        avm = service.saveAlbum(avm);
//
//        AlbumViewModel fromService = service.findAlbum(avm.getId());
//
//        assertEquals(avm, fromService);
//
//    }
}