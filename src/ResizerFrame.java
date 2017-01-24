/*
 *
 
 Copyright (c) 2014, Sebastian Breit
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 
 
 * 
 * */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class ResizerFrame extends JFrame {

    private JPanel contentPane;
    private JPanel panel_1;
    private JLabel lblAndroidResourcesDirectory;
    private JButton btnAndroidBrowse;
    private JLabel lblAndroidNoDirectorySelected;
    private JLabel lblIosResourcesDirectory;
    private JButton btnIosBrowse;
    private JLabel lblIosNoDirectorySelected;
    private JLabel lblWindowsResourcesDirectory;
    private JButton btnWindowsBrowse;
    private JLabel lblWindowsNoDirectorySelected;
    private JLabel lblDragYourImages;
    private JPanel panel_2;
    private JLabel lblDragYourImages_1;
    private JPanel panel_3;
    private JLabel lblNewLabel;
    private JPanel panel_4;
    private JLabel lblDragDrop;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ResizerFrame frame = new ResizerFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    File androidResFile = null;
    File iosResFile = null;
    File windowsResFile = null;
    private JLabel lblInputDensity;
    private JComboBox<String> inputDensity;
    private JLabel lblInputDirectory;
    private JComboBox<String> inputDirectory;
    private JCheckBox ch_overwrite;
    private JCheckBox ch_xxxhdpi;
    private JCheckBox ch_tvdpi;
    private JCheckBox ch_ldpi;
    private JCheckBox ch_mdpi;
    private JCheckBox ch_hdpi;
    private JCheckBox ch_xhdpi;
    private JCheckBox ch_xxhdpi;
    private JCheckBox ch_1x;
    private JCheckBox ch_15x;
    private JCheckBox ch_2x;
    private JCheckBox ch_3x;
    private JCheckBox ch_4x;
    private JCheckBox ch_windows;

    public ResizerFrame() {
        super("Final Android Resizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Export"));
        contentPane.add(panel, BorderLayout.WEST);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{56, 0};
        gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 1.0};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        ch_ldpi = new JCheckBox("ldpi");
        ch_ldpi.setSelected(true);
        GridBagConstraints gbc_ch_ldpi = new GridBagConstraints();
        gbc_ch_ldpi.insets = new Insets(0, 0, 5, 5);
        gbc_ch_ldpi.anchor = GridBagConstraints.NORTHWEST;
        gbc_ch_ldpi.gridx = 0;
        gbc_ch_ldpi.gridy = 0;
        panel.add(ch_ldpi, gbc_ch_ldpi);

        ch_mdpi = new JCheckBox("mdpi");
        ch_mdpi.setSelected(true);
        ch_mdpi.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_ch_mdpi = new GridBagConstraints();
        gbc_ch_mdpi.anchor = GridBagConstraints.WEST;
        gbc_ch_mdpi.insets = new Insets(0, 0, 5, 5);
        gbc_ch_mdpi.gridx = 0;
        gbc_ch_mdpi.gridy = 1;
        panel.add(ch_mdpi, gbc_ch_mdpi);

        ch_tvdpi = new JCheckBox("tvdpi");
        GridBagConstraints gbc_ch_tvdpi = new GridBagConstraints();
        gbc_ch_tvdpi.anchor = GridBagConstraints.WEST;
        gbc_ch_tvdpi.insets = new Insets(0, 0, 5, 5);
        gbc_ch_tvdpi.gridx = 0;
        gbc_ch_tvdpi.gridy = 2;
        panel.add(ch_tvdpi, gbc_ch_tvdpi);

        ch_hdpi = new JCheckBox("hdpi");
        ch_hdpi.setSelected(true);
        GridBagConstraints gbc_ch_hdpi = new GridBagConstraints();
        gbc_ch_hdpi.anchor = GridBagConstraints.WEST;
        gbc_ch_hdpi.insets = new Insets(0, 0, 5, 5);
        gbc_ch_hdpi.gridx = 0;
        gbc_ch_hdpi.gridy = 3;
        panel.add(ch_hdpi, gbc_ch_hdpi);

        ch_xhdpi = new JCheckBox("xhdpi");
        ch_xhdpi.setSelected(true);
        GridBagConstraints gbc_ch_xhdpi = new GridBagConstraints();
        gbc_ch_xhdpi.anchor = GridBagConstraints.WEST;
        gbc_ch_xhdpi.insets = new Insets(0, 0, 5, 5);
        gbc_ch_xhdpi.gridx = 0;
        gbc_ch_xhdpi.gridy = 4;
        panel.add(ch_xhdpi, gbc_ch_xhdpi);

        ch_xxhdpi = new JCheckBox("xxhdpi");
        ch_xxhdpi.setSelected(true);
        GridBagConstraints gbc_ch_xxhdpi = new GridBagConstraints();
        gbc_ch_xxhdpi.anchor = GridBagConstraints.WEST;
        gbc_ch_xxhdpi.insets = new Insets(0, 0, 5, 5);
        gbc_ch_xxhdpi.gridx = 0;
        gbc_ch_xxhdpi.gridy = 5;
        panel.add(ch_xxhdpi, gbc_ch_xxhdpi);

        ch_xxxhdpi = new JCheckBox("xxxhdpi");
        ch_xxxhdpi.setSelected(true);
        GridBagConstraints gbc_ch_xxxhdpi = new GridBagConstraints();
        gbc_ch_xxxhdpi.insets = new Insets(0, 0, 5, 5);
        gbc_ch_xxxhdpi.gridx = 0;
        gbc_ch_xxxhdpi.gridy = 6;
        panel.add(ch_xxxhdpi, gbc_ch_xxxhdpi);

        ch_1x = new JCheckBox("@1x");
        ch_1x.setSelected(true);
        GridBagConstraints gbc_ch_1x = new GridBagConstraints();
        gbc_ch_1x.insets = new Insets(0, 0, 5, 5);
        gbc_ch_1x.gridx = 0;
        gbc_ch_1x.gridy = 7;
        panel.add(ch_1x, gbc_ch_1x);

        ch_15x = new JCheckBox("@1.5x");
        ch_15x.setSelected(true);
        GridBagConstraints gbc_ch_15x = new GridBagConstraints();
        gbc_ch_15x.insets = new Insets(0, 0, 5, 5);
        gbc_ch_15x.gridx = 0;
        gbc_ch_15x.gridy = 8;
        panel.add(ch_15x, gbc_ch_15x);

        ch_2x = new JCheckBox("@2x");
        ch_2x.setSelected(true);
        GridBagConstraints gbc_ch_2x = new GridBagConstraints();
        gbc_ch_2x.insets = new Insets(0, 0, 5, 5);
        gbc_ch_2x.gridx = 0;
        gbc_ch_2x.gridy = 9;
        panel.add(ch_2x, gbc_ch_2x);

        ch_3x = new JCheckBox("@3x");
        ch_3x.setSelected(true);
        GridBagConstraints gbc_ch_3x = new GridBagConstraints();
        gbc_ch_3x.insets = new Insets(0, 0, 5, 5);
        gbc_ch_3x.gridx = 0;
        gbc_ch_3x.gridy = 10;
        panel.add(ch_3x, gbc_ch_3x);

        ch_4x = new JCheckBox("@4x");
        ch_4x.setSelected(true);
        GridBagConstraints gbc_ch_4x = new GridBagConstraints();
        gbc_ch_4x.insets = new Insets(0, 0, 5, 5);
        gbc_ch_4x.gridx = 0;
        gbc_ch_4x.gridy = 11;
        panel.add(ch_4x, gbc_ch_4x);

        ch_windows = new JCheckBox("windows");
        ch_windows.setSelected(true);
        GridBagConstraints gbc_ch_windows = new GridBagConstraints();
        gbc_ch_windows.insets = new Insets(0, 0, 5, 5);
        gbc_ch_windows.gridx = 0;
        gbc_ch_windows.gridy = 12;
        panel.add(ch_windows, gbc_ch_windows);

        panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder("Options"));
        contentPane.add(panel_1, BorderLayout.NORTH);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0,
                Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0};
        panel_1.setLayout(gbl_panel_1);

        addAndroidDirectoryChooser();
        addIosDirectoryChooser();
        addWindowsDirectoryChooser();

        addInputFields();

        addOverwriteCheckbox();

        panel_4 = new JPanel();
        contentPane.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        lblDragDrop = new JLabel("Drag & drop your image(s) here");
        panel_4.add(lblDragDrop, gbc);

        new FileDrop(System.out, panel_4, /* dragBorder, */
                files -> {
                    if (androidResFile == null && iosResFile == null && windowsResFile == null) {
                        showWarning("Please select a destination folder first!");
                        return;
                    }

                    lblDragDrop.setText("Processing...");

                    if (androidResFile != null) {
                        Thread t = new Thread(() -> {
                            Vector<String> export = getAndroidFolders();

                            for (int i = 0; i < files.length; i++) {
                                for (String exportString : export) {
                                    try {
                                        ImageProcessor.processImage(files[i],
                                                androidResFile, (String) inputDensity
                                                        .getSelectedItem(), (String) inputDirectory.getSelectedItem(), ch_overwrite.isSelected(),
                                                exportString, ImageProcessor.DrawableType.ANDROID);
                                    } catch (FileAlreadyExistsException e) {
                                        showWarning("The file "
                                                + files[i].getName()
                                                + " already exists! This image will not be processed.");
                                        break;
                                    } catch (IOException e) {
                                        showError("An IO Error occurred while processing "
                                                + files[i].getName());
                                        e.printStackTrace();
                                        break;
                                    } catch (NullPointerException e) {
                                        showError("The file "
                                                + files[i].getName()
                                                + " is not an image and will be omitted");
                                        e.printStackTrace();
                                        break;
                                    }

                                    lblDragDrop.setText(lblDragDrop.getText() + ".");
                                }
                            }
                            lblDragDrop.setText("Done! Gimme some more...");
                        });
                        t.start();
                    }

                    if (iosResFile != null) {
                        Thread t = new Thread(() -> {
                            Vector<String> export = getIosFolders();

                            for (int i = 0; i < files.length; i++) {
                                for (String exportString : export) {
                                    try {
                                        ImageProcessor.processImage(files[i],
                                                iosResFile, (String) inputDensity
                                                        .getSelectedItem(), (String) inputDirectory.getSelectedItem(), ch_overwrite.isSelected(),
                                                exportString, ImageProcessor.DrawableType.IOS);
                                    } catch (FileAlreadyExistsException e) {
                                        showWarning("The file "
                                                + files[i].getName()
                                                + " already exists! This image will not be processed.");
                                        break;
                                    } catch (IOException e) {
                                        showError("An IO Error occurred while processing "
                                                + files[i].getName());
                                        e.printStackTrace();
                                        break;
                                    } catch (NullPointerException e) {
                                        showError("The file "
                                                + files[i].getName()
                                                + " is not an image and will be omitted");
                                        e.printStackTrace();
                                        break;
                                    }

                                    lblDragDrop.setText(lblDragDrop.getText() + ".");
                                }
                            }
                            lblDragDrop.setText("Done! Gimme some more...");
                        });
                        t.start();
                    }

                    if (windowsResFile != null) {
                        Thread t = new Thread(() -> {
                            Vector<String> export = getWindowsFolders();

                            for (int i = 0; i < files.length; i++) {
                                for (String exportString : export) {
                                    try {
                                        ImageProcessor.processImage(files[i],
                                                windowsResFile, (String) inputDensity
                                                        .getSelectedItem(), (String) inputDirectory.getSelectedItem(), ch_overwrite.isSelected(),
                                                exportString, ImageProcessor.DrawableType.WINDOWS);
                                    } catch (FileAlreadyExistsException e) {
                                        showWarning("The file "
                                                + files[i].getName()
                                                + " already exists! This image will not be processed.");
                                        break;
                                    } catch (IOException e) {
                                        showError("An IO Error occurred while processing "
                                                + files[i].getName());
                                        e.printStackTrace();
                                        break;
                                    } catch (NullPointerException e) {
                                        showError("The file "
                                                + files[i].getName()
                                                + " is not an image and will be omitted");
                                        e.printStackTrace();
                                        break;
                                    }

                                    lblDragDrop.setText(lblDragDrop.getText() + ".");
                                }
                            }
                            lblDragDrop.setText("Done! Gimme some more...");
                        });
                        t.start();
                    }

                });

    }

    private void addAndroidDirectoryChooser() {
        // Android Directories
        lblAndroidResourcesDirectory = new JLabel("Android directory:");
        GridBagConstraints gbc_lblResourcesDirectory = new GridBagConstraints();
        gbc_lblResourcesDirectory.anchor = GridBagConstraints.WEST;
        gbc_lblResourcesDirectory.insets = new Insets(0, 0, 5, 5);
        gbc_lblResourcesDirectory.gridx = 0;
        gbc_lblResourcesDirectory.gridy = 0;
        panel_1.add(lblAndroidResourcesDirectory, gbc_lblResourcesDirectory);

        btnAndroidBrowse = new JButton("Browse");
        btnAndroidBrowse.addActionListener(arg0 -> {
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            Integer returnVal = j.showOpenDialog(btnAndroidBrowse);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                androidResFile = j.getSelectedFile();
                lblAndroidNoDirectorySelected.setText(androidResFile.getAbsolutePath());
                pack();
            }
        });
        GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
        gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
        gbc_btnBrowse.gridx = 1;
        gbc_btnBrowse.gridy = 0;
        panel_1.add(btnAndroidBrowse, gbc_btnBrowse);

        lblAndroidNoDirectorySelected = new JLabel("No Android directory selected yet");
        GridBagConstraints gbc_lblNoDirectorySelected = new GridBagConstraints();
        gbc_lblNoDirectorySelected.insets = new Insets(0, 0, 5, 0);
        gbc_lblNoDirectorySelected.gridx = 2;
        gbc_lblNoDirectorySelected.gridy = 0;
        panel_1.add(lblAndroidNoDirectorySelected, gbc_lblNoDirectorySelected);
    }

    private void addIosDirectoryChooser() {
        // IOS Directories
        lblIosResourcesDirectory = new JLabel("iOS directory:");
        GridBagConstraints gbc_lblResourcesDirectory = new GridBagConstraints();
        gbc_lblResourcesDirectory.anchor = GridBagConstraints.WEST;
        gbc_lblResourcesDirectory.insets = new Insets(0, 0, 5, 5);
        gbc_lblResourcesDirectory.gridx = 0;
        gbc_lblResourcesDirectory.gridy = 1;
        panel_1.add(lblIosResourcesDirectory, gbc_lblResourcesDirectory);

        btnIosBrowse = new JButton("Browse");
        btnIosBrowse.addActionListener(arg0 -> {
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            Integer returnVal = j.showOpenDialog(btnIosBrowse);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                iosResFile = j.getSelectedFile();
                lblIosNoDirectorySelected.setText(iosResFile.getAbsolutePath());
                pack();
            }
        });
        GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
        gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
        gbc_btnBrowse.gridx = 1;
        gbc_btnBrowse.gridy = 1;
        panel_1.add(btnIosBrowse, gbc_btnBrowse);

        lblIosNoDirectorySelected = new JLabel("No iOS directory selected yet");
        GridBagConstraints gbc_lblNoDirectorySelected = new GridBagConstraints();
        gbc_lblNoDirectorySelected.insets = new Insets(0, 0, 5, 0);
        gbc_lblNoDirectorySelected.gridx = 2;
        gbc_lblNoDirectorySelected.gridy = 1;
        panel_1.add(lblIosNoDirectorySelected, gbc_lblNoDirectorySelected);
    }

    private void addWindowsDirectoryChooser() {
        //Windows
        lblWindowsResourcesDirectory = new JLabel("Windows directory:");
        GridBagConstraints gbc_lblResourcesDirectory = new GridBagConstraints();
        gbc_lblResourcesDirectory.anchor = GridBagConstraints.WEST;
        gbc_lblResourcesDirectory.insets = new Insets(0, 0, 5, 5);
        gbc_lblResourcesDirectory.gridx = 0;
        gbc_lblResourcesDirectory.gridy = 2;
        panel_1.add(lblWindowsResourcesDirectory, gbc_lblResourcesDirectory);

        btnWindowsBrowse = new JButton("Browse");
        btnWindowsBrowse.addActionListener(arg0 -> {
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            Integer returnVal = j.showOpenDialog(btnWindowsBrowse);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                windowsResFile = j.getSelectedFile();
                lblWindowsNoDirectorySelected.setText(windowsResFile.getAbsolutePath());
                pack();
            }
        });
        GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
        gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
        gbc_btnBrowse.gridx = 1;
        gbc_btnBrowse.gridy = 2;
        panel_1.add(btnWindowsBrowse, gbc_btnBrowse);

        lblWindowsNoDirectorySelected = new JLabel("No Windows directory selected yet");
        GridBagConstraints gbc_lblNoDirectorySelected = new GridBagConstraints();
        gbc_lblNoDirectorySelected.insets = new Insets(0, 0, 5, 0);
        gbc_lblNoDirectorySelected.gridx = 2;
        gbc_lblNoDirectorySelected.gridy = 2;
        panel_1.add(lblWindowsNoDirectorySelected, gbc_lblNoDirectorySelected);
    }

    private void addInputFields() {
        lblInputDensity = new JLabel("Input density");
        GridBagConstraints gbc_lblInputDensity = new GridBagConstraints();
        gbc_lblInputDensity.anchor = GridBagConstraints.WEST;
        gbc_lblInputDensity.insets = new Insets(0, 0, 0, 5);
        gbc_lblInputDensity.gridx = 0;
        gbc_lblInputDensity.gridy = 4;
        panel_1.add(lblInputDensity, gbc_lblInputDensity);

        Vector<String> comboBoxItems = new Vector<String>();
        comboBoxItems.add("ldpi");
        comboBoxItems.add("mdpi");
        comboBoxItems.add("hdpi");
        comboBoxItems.add("xhdpi");
        comboBoxItems.add("xxhdpi");
        comboBoxItems.add("xxxhdpi");
        comboBoxItems.add("@1x");
        comboBoxItems.add("@1.5x");
        comboBoxItems.add("@2x");
        comboBoxItems.add("@3x");
        comboBoxItems.add("@4x");
        final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(
                comboBoxItems);
        inputDensity = new JComboBox<>(model);
        inputDensity.setSelectedIndex(4);
        GridBagConstraints gbc_inputDensity = new GridBagConstraints();
        gbc_inputDensity.insets = new Insets(0, 0, 0, 5);
        gbc_inputDensity.fill = GridBagConstraints.HORIZONTAL;
        gbc_inputDensity.gridx = 1;
        gbc_inputDensity.gridy = 4;
        panel_1.add(inputDensity, gbc_inputDensity);

        lblInputDirectory = new JLabel("Output directory");
        GridBagConstraints gbc_lblInputDirectory = new GridBagConstraints();
        gbc_lblInputDirectory.anchor = GridBagConstraints.WEST;
        gbc_lblInputDirectory.insets = new Insets(0, 0, 0, 5);
        gbc_lblInputDirectory.gridx = 2;
        gbc_lblInputDirectory.gridy = 4;
        panel_1.add(lblInputDirectory, gbc_lblInputDirectory);

        Vector<String> comboBoxItemsDirectory = new Vector<>();
        comboBoxItemsDirectory.add("mipmap");
        comboBoxItemsDirectory.add("drawable");
        final DefaultComboBoxModel<String> modelDirectory = new DefaultComboBoxModel<String>(
                comboBoxItemsDirectory);
        inputDirectory = new JComboBox<>(modelDirectory);
        inputDirectory.setSelectedIndex(0);
        GridBagConstraints gbc_inputDirectory = new GridBagConstraints();
        gbc_inputDirectory.insets = new Insets(0, 0, 0, 5);
        gbc_inputDirectory.fill = GridBagConstraints.HORIZONTAL;
        gbc_inputDirectory.gridx = 3;
        gbc_inputDirectory.gridy = 4;
        panel_1.add(inputDirectory, gbc_inputDirectory);
    }

    private void addOverwriteCheckbox() {
        ch_overwrite = new JCheckBox("Overwrite drawable");
        ch_overwrite.setSelected(true);
        GridBagConstraints gbc_ch_overwrite = new GridBagConstraints();
        gbc_ch_overwrite.insets = new Insets(0, 0, 0, 5);
        gbc_ch_overwrite.fill = GridBagConstraints.HORIZONTAL;
        gbc_ch_overwrite.gridx = 0;
        gbc_ch_overwrite.gridy = 5;
        panel_1.add(ch_overwrite, gbc_ch_overwrite);
    }

    private Vector<String> getAndroidFolders() {
        Vector<String> ret = new Vector<>();

        if (ch_ldpi.isSelected())
            ret.add("ldpi");

        if (ch_mdpi.isSelected())
            ret.add("mdpi");

        if (ch_tvdpi.isSelected())
            ret.add("tvdpi");

        if (ch_hdpi.isSelected())
            ret.add("hdpi");

        if (ch_xhdpi.isSelected())
            ret.add("xhdpi");

        if (ch_xxhdpi.isSelected())
            ret.add("xxhdpi");

        if (ch_xxxhdpi.isSelected())
            ret.add("xxxhdpi");

        return ret;
    }

    private Vector<String> getIosFolders() {
        Vector<String> ret = new Vector<>();

        if (ch_1x.isSelected())
            ret.add("@1x");

        if (ch_15x.isSelected())
            ret.add("@1.5x");

        if (ch_2x.isSelected())
            ret.add("@2x");

        if (ch_3x.isSelected())
            ret.add("@3x");

        if (ch_4x.isSelected())
            ret.add("@4x");

        return ret;
    }

    private Vector<String> getWindowsFolders() {
        Vector<String> ret = new Vector<>();

        if (ch_windows.isSelected())
            ret.add("windows");

        return ret;
    }

    private void showError(String text) {
        JOptionPane.showMessageDialog(this, text, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void showWarning(String text) {
        JOptionPane.showMessageDialog(this, text, "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

}
