package com.miniproject.dlsestimator;

import android.support.v4.app.Fragment;

public class CalculatorActivity extends SingleFragmentActivity
        implements InningsFragment.Callbacks, ResultFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return CalculatorFragment.newInstance();
    }


    @Override
    public void nextPage() {
        CalculatorFragment calculatorFragment  = (CalculatorFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
        calculatorFragment.nextPage();
    }

    @Override
    public void resetCalculation() {
        CalculationLab calculationLab = CalculationLab.get(this);
        calculationLab.initialiseCalculation();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, createFragment()).commit();
    }
}
