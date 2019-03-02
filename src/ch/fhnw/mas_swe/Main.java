package ch.fhnw.mas_swe;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * @author David Herzig
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Program started...");

        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("led is on...");

        Thread.sleep(5000);

        pin.low();
        System.out.println("led is off...");

        Thread.sleep(5000);

        pin.toggle();
        System.out.println("led is on...");

        Thread.sleep(5000);

        pin.toggle();
        System.out.println("led is off...");

        gpio.shutdown();
        gpio.unprovisionPin(pin);
    }
}
