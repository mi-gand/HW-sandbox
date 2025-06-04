package org.example.adapter;

public class Computer {
    public void readFromUsb(UsbInterface device) {
        device.getContent();
    }

    public static void main(String[] args) {
        SdCard sdCard = new SdCard();
        UsbInterface adapter = new SdToUsbAdapter(sdCard);

        Computer computer = new Computer();
        computer.readFromUsb(adapter);
    }
}

interface UsbInterface {
    void getContent();
}

class SdCard {
    public void readData() {
        System.out.println("Чтение с SD-карты");
    }
}

class SdToUsbAdapter implements UsbInterface {
    private final SdCard sdCard;

    public SdToUsbAdapter(SdCard sdCard) {
        this.sdCard = sdCard;
    }

    @Override
    public void getContent() {
        sdCard.readData();
    }
}