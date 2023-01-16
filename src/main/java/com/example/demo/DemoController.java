package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DemoController {

    @RequestMapping("/home")
    public String hello()
    {
String dataDir = "dataDir/";

// Create an instance of TiffImage and load the file from disc
try (TiffImage multiImage = (TiffImage)Image.load(dataDir + "test_data.tiff"))
{
    // Initialize a variable to keep track of the frames in the image, Iterate over the tiff frame collection and Save the image
    int i = 0;
    for (TiffFrame tiffFrame : multiImage.getFrames())
    {
        tiffFrame.save(dataDir + i + "_out.tiff", new TiffOptions(TiffExpectedFormat.TiffJpegRgb));
    }
}

    }
}

