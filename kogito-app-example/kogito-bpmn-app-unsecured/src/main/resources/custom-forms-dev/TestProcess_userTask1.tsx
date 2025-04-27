import React, { useCallback, useEffect, useState } from 'react';
import { TextInput, FormGroup, Checkbox } from '@patternfly/react-core';
const Form__TestProcess_userTask1: React.FC<any> = (props: any) => {
	const [formApi, setFormApi] = useState<any>();
	const [variable1, set__variable1] = useState<string>('');
	const [variable2, set__variable2] = useState<string>('');
	const [variable3, set__variable3] = useState<string>('');
	const [variable4, set__variable4] = useState<string>('');
	const [repeatTask, set__repeatTask] = useState<boolean>(false);
	/* Utility function that fills the form with the data received from the kogito runtime */
	const setFormData = (data) => {
		if (!data) {
			return;
		}
		set__variable1(data?.variable1 ?? '');
		set__variable2(data?.variable2 ?? '');
		set__variable3(data?.variable3 ?? '');
		set__variable4(data?.variable4 ?? '');
		set__repeatTask(data?.repeatTask ?? false);
	};
	/* Utility function to generate the expected form output as a json object */
	const getFormData = useCallback(() => {
		const formData: any = {};
		formData.repeatTask = repeatTask;
		return formData;
	}, [repeatTask]);
	/* Utility function to validate the form on the 'beforeSubmit' Lifecycle Hook */
	const validateForm = useCallback(() => {}, []);
	/* Utility function to perform actions on the on the 'afterSubmit' Lifecycle Hook */
	const afterSubmit = useCallback((result) => {}, []);
	useEffect(() => {
		if (formApi) {
			/*
        Form Lifecycle Hook that will be executed before the form is submitted.
        Throwing an error will stop the form submit. Usually should be used to validate the form.
      */
			formApi.beforeSubmit = () => validateForm();
			/*
        Form Lifecycle Hook that will be executed after the form is submitted.
        It will receive a response object containing the `type` flag indicating if the submit has been successful and `info` with extra information about the submit result.
      */
			formApi.afterSubmit = (result) => afterSubmit(result);
			/* Generates the expected form output object to be posted */
			formApi.getFormData = () => getFormData();
		}
	}, [getFormData, validateForm, afterSubmit]);
	useEffect(() => {
		/*
      Call to the Kogito console form engine. It will establish the connection with the console embeding the form
      and return an instance of FormAPI that will allow hook custom code into the form lifecycle.
      The `window.Form.openForm` call expects an object with the following entries:
        - onOpen: Callback that will be called after the connection with the console is established. The callback
        will receive the following arguments:
          - data: the data to be bound into the form
          - ctx: info about the context where the form is being displayed. This will contain information such as the form JSON Schema, process/task, user...
    */
		const api = window.Form.openForm({
			onOpen: (data, context) => {
				setFormData(data);
			},
		});
		setFormApi(api);
	}, []);
	return (
		<div className={'pf-c-form'}>
			<FormGroup
				fieldId={'uniforms-000g-0000'}
				label={'Variable 1'}
				isRequired={false}>
				<TextInput
					name={'variable1'}
					id={'uniforms-000g-0000'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={variable1}
					onChange={set__variable1}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000g-0001'}
				label={'Variable 2'}
				isRequired={false}>
				<TextInput
					name={'variable2'}
					id={'uniforms-000g-0001'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={variable2}
					onChange={set__variable2}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000g-0002'}
				label={'Variable 3'}
				isRequired={false}>
				<TextInput
					name={'variable3'}
					id={'uniforms-000g-0002'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={variable3}
					onChange={set__variable3}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000g-0003'}
				label={'Variable 4'}
				isRequired={false}>
				<TextInput
					name={'variable4'}
					id={'uniforms-000g-0003'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={variable4}
					onChange={set__variable4}
				/>
			</FormGroup>
			<FormGroup fieldId='uniforms-000g-0005'>
				<Checkbox
					isChecked={repeatTask}
					isDisabled={false}
					id={'uniforms-000g-0005'}
					name={'repeatTask'}
					label={'Repeat task'}
					onChange={set__repeatTask}
				/>
			</FormGroup>
		</div>
	);
};
export default Form__TestProcess_userTask1;
